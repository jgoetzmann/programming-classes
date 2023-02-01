# Jack Goetzmann
# Adv Prog Data Viz
# January 2023

# There is a massive difference between the way my viz looks compared to what it
# was supposed to look like. First it is blue instead of red since I could
# not figure out how to change the color. Second I do not have the lables on the
# legend or the popup lable when you look over the graph. And finally, I could 
# not figure out of to exactly have the same bins as the one provided.
# I was working on adding the lables to the graph when you hover over the viz.
# And in the future I would like to figure out the exact color and focus on more
# of the smaller details.

import pandas as pd
import geopandas as gp
import folium

# smaller CSV file from August 18, 2020
csv_path = "HW03-RecreateChoropleth\\United_States_COVID-19_County_Level_of_Community_Transmission_as_Originally_Posted_-_ARCHIVED.csv"

# geo json file provided 
json_path = "HW03-RecreateChoropleth\\geojson-counties-fips.json"

# read in files using (geo)pandas
geo_data = gp.read_file(json_path)
cdc_data = pd.read_csv(csv_path)

# makes "fips_code" a string
cdc_data["fips_code"].apply(str)

# drops empty/na values
cdc_data.dropna(inplace = True)

# drops suppressed data
cdc_data['cases_per_100K_7_day_count_change'].replace('suppressed', '0',
    inplace = True)
cdc_data.drop(cdc_data[cdc_data.cases_per_100K_7_day_count_change == 0].index)

# changes string to float
cdc_data['cases_per_100K_7_day_count_change'] = cdc_data[
    'cases_per_100K_7_day_count_change'].str.replace(',', '').astype(float)

# drops columns
cleaned_geo_data = geo_data.drop(["GEO_ID", "STATE", "COUNTY", "LSAD",
    "CENSUSAREA"], axis=1)

# preps data to be merged
cleaned_geo_data['NAME'] = cleaned_geo_data['NAME'].astype(str) + ' County'
cdc_data.rename(columns = {"county_name": "NAME"}, inplace=True)

# merges data
complete_data = cleaned_geo_data.merge(cdc_data, on='NAME')

# This defines the bins to create the desired visualization
custom_bins = list(complete_data["cases_per_100K_7_day_count_change"].quantile(
    [0, 0.2, 0.4, 0.6, 0.8, 1]))

# creates folium_map
folium_map = folium.Map()

# makes the choropleth.
choropleth = folium.Choropleth(
    data = complete_data, # adds completed data set
    geo_data = complete_data, # geo data
    columns = ['fips_code', 'cases_per_100K_7_day_count_change'], # columns
    key_on = 'feature.properties.fips_code', # keys columns
    fill_opacity = 0.7, # opacities
    bins=custom_bins # bins
).add_to(folium_map)

# makes file
folium_map.save('coolvizual.html')
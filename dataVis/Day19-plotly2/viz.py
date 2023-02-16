# Jack Goetzmann
# Adv Prog Data Viz
# December 2022
# A file that creates a visualization of the likelihood of either party holding
# the house over a period of time.
# Used house_national_toplines_2022 from the github
# I did not import timestamp and only imported the repub and dem chamber data
# as there was data for everyday. There arnt as fancy lines and the viz isnt
# as clear as the goal viz.
# I am working on making sure I have the correct data to their graph as I am 
# confused on how my data is so much different than their data displayed (
# could be a problem in that I only use lite exression type)

import pandas as pd
import matplotlib.pyplot as plt

# Creates Data Frame
df = pd.read_csv('dataVis\HW02-RecreateViz\house_national_toplines_2022.csv')

# Drop Columns (other than expression type, forecastdate, chamber_D/Rparty)
df.drop(['cycle', 'branch', 'mean_seats_Dparty', 'mean_seats_Rparty',
    'median_seats_Dparty', 'median_seats_Rparty', 'median_seats_Rparty',
 	'p90_seats_Dparty',	'p90_seats_Rparty',	'p10_seats_Dparty',
    'p10_seats_Rparty', 'total_national_turnout', 'p90_total_national_turnout',
	'p10_total_national_turnout', 'popvote_margin', 'p90_popvote_margin', 
    'p10_popvote_margin', 'statesmajority_Dparty', 'statesmajority_Rparty', 
    'statesmajority_noparty', 'delegations_Dparty', 'delegations_Rparty', 
    'delegations_nomajority', 'simulations', 'timestamp',
], axis=1, inplace=True)

# Drop Rows (other than lite)
df.drop(df.index[153:], axis=0, inplace=True)

# Sets forecastdate to date time format
df['forecastdate'] = pd.to_datetime(df['forecastdate'])

# print(df)
# print(df.info)

# Takes data and makes it an array
chamber_Dparty = df['chamber_Dparty'].to_numpy(dtype='float')
chamber_Rparty = df['chamber_Rparty'].to_numpy(dtype='float')

# Creates graph
fig,ax = plt.subplots()

# Plots graph
ax.plot(chamber_Dparty, label="dem_chamver")
ax.plot(chamber_Rparty, label="rep_chamber")

# Sets Y tick value on graph
ax.set_yticks([0.0, 0.20, 0.40, 0.60, 0.80, 1.00])
ax.set_yticklabels(['0', '20', '40', '60', '80', '100%'])

# Sets X tick value on graph
ax.set_xticks([0, 30, 60, 90, 120, 150])
ax.set_xticklabels(['June 1', 'July 1', 'Aug. 1', 'Sept. 1', 'Oct. 1', 
'Nov. 1'])
ax.set_title("Chances of controlling the House")

# Shows graph
plt.show()
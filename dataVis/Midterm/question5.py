# Jack Goetzmann
# Adv Prog Data Viz
# January 2023
# Error Section of Midterm

# Couldnt add color

import pandas as pd
import matplotlib.pyplot as plt

# Read in
df = pd.read_csv("Midterm\hotel_bookings.csv")

# Added drop duplicates (so you dont get a bunch of portugals)
df = df.drop_duplicates()

# Cleans data
df['country'].fillna('Others',inplace=True)
country_df=df['country'].value_counts().reset_index()
country_df = country_df.rename(columns={'index': 'country','country': 'count of guests'})[:15]

fig,ax = plt.subplots(figsize=(20,8))

# Added lables and title here
ax.set_title("Number of guests from different Countries")
ax.set_xlabel("Country")
ax.set_ylabel("Number of guests")

# Change scatter to bar since its a bar chart not a scatter chart
ax.bar(country_df['country'],country_df['count of guests'])

plt.show()
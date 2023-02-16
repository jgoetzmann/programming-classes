# Jack Goetzmann
# Adv Prog Data Viz
# February 2022

# A graph showing the correlation between values in the house_national_toplines
# data set using seaborn.

import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# Creates Data Frame
df = pd.read_csv('HW04-Refresher\\seaborn-assignments\\house_national_toplines_2022.csv')

# Does some basic cleaning
df.drop(df.index[153:], axis=0, inplace=True)
df.drop(['cycle', 'branch', 'expression', 'forecastdate', 'mean_seats_Dparty', 
    'mean_seats_Rparty', 'median_seats_Dparty', 'median_seats_Rparty',
    'median_seats_Rparty', 'p90_seats_Dparty',	'p90_seats_Rparty',
    'statesmajority_Dparty', 'statesmajority_Rparty', 'statesmajority_noparty',
    'delegations_Dparty', 'delegations_Rparty', 'delegations_nomajority', 
    'simulations', 'timestamp',
], axis=1, inplace=True)

# Theme
sns.set_style("darkgrid") 

# Heatmap
corr = df.corr()
map = sns.heatmap(corr, cmap='coolwarm', annot=True)

# Matplot lib interface
map.set_xlabel("This title exists but you cant see it bc")
map.set_ylabel("I did not change the axis yet")
map.set_title("I made a cool title using matplotlib\'s interface")

plt.show()

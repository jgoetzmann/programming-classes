import plotly.graph_objects as go
import numpy as np
import plotly
#combined plots

import pandas as pd
import matplotlib.pyplot as plt

# Creates Data Frame
df = pd.read_csv('Day19-plotly2\house_national_toplines_2022.csv')

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

fig = go.Figure()
# Add traces
fig.add_trace(go.Scatter(x=chamber_Dparty,
                    mode='lines+markers',
                    name='lines+markers'))
fig.add_trace(go.Scatter(x = chamber_Dparty,
                    mode='markers',
                    name='markers'))
fig.add_trace(go.Scatter(x= chamber_Dparty,
                    mode='lines',
                    name='lines'))
# fig.show()  
plotly.offline.plot(fig, filename='second_attempt.html')
# Jack Goetzmann
# Adv Prog Data Viz
# February 2022

# A graph showing the ability to use plotly and more specifically the ability to
# have basic animation using the pokemon dataset and base stat total of 6 
# pokemon with 3 stages

import plotly.express as px
import pandas as pd
import plotly

# Reads in data
df = pd.read_csv("HW04-Refresher\\plotly-assignments\\Pokemon.csv")

# Basic cleaning
real_df = df.drop(df.index[18:], axis=0)

print(real_df)

# Makes scatter plot
fig = px.scatter(real_df, 
                x ="Name", 
                y ="Total", 
                animation_frame ="Stage", 
                size ="Total", 
                range_y =[0, 800]
)
fig.show()

plotly.offline.plot(fig, filename='animation.html')

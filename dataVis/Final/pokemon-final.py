# Jack Goetzmann
# Advanced Programming: Data Viz
# March 2023
#
# data: https://www.smogon.com/stats/2018-06/gen7ou-0.txt
# data: https://www.kaggle.com/datasets/rounakbanik/pokemon
# purpose: this program creates 5 different graphs using Pokemon dataset
#
# analysis of bias: I was tried to be as non-biased as possible. The bias thing
# I could have done was when I dropped some data points that were na or used  
# 1000 times (which would correlate to being used 0.03%> of the time). I did not
# drop these to to make my graph look better, I did it to makesure that I only
# had statistically signifigant data points which still skews is as a person was
# cut out from the dataset by me doing that. I did not scale my graphs to hide
# data points or to manipulate the meaning of the graphs. I did not use colors 
# to emphasize parts of my graphs. I made sure to name the graph titles and axis
# when necessary.

import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from wordcloud import WordCloud
import plotly.graph_objects as go
import plotly.express as px
import plotly.offline
import plotly

# Reads in files
norm_stats = pd.read_csv('Final\\pokemon.csv')
comp_stats = pd.read_csv('Final\\gen7ou-usage.csv')

# print(norm_stats)
# print(comp_stats)

### Cleaning

norm_stats.info()
comp_stats.info()

comp_stats['Usage%'] = comp_stats['Usage%'].str.rstrip("%").astype(float)/100

comp_stats.info()

# Drops all pokemon in comp_stats that have less than 1000 real games
for x in comp_stats.index:
    if comp_stats.loc[x, "Real"] < 1000:
        comp_stats.drop(x, axis=0, inplace=True)
        # print(x)

# Prep the merge by renamining pokemon to name
comp_stats = comp_stats.rename(columns={'Pokemon': 'name'})

# Merge together both of the data frames
merged_stats = pd.merge(comp_stats, norm_stats, on='name')

# Drops na values
merged_stats = merged_stats.dropna(axis=1)
merged_stats = merged_stats.dropna(axis=0)

# Prints to understand what is going on
print(merged_stats.head(20))
print(merged_stats.info())
print(merged_stats.columns)
# print(merged_stats)

### Graph 1 - heatmap

# Get the correlation between each column in merged_stats dataframe
corr = merged_stats.corr()

# Increase the size of the heatmap and create a figure and axes objects
fig, ax = plt.subplots(figsize=(30,30))

# Makes heatmap and set the title
heatmap = sns.heatmap(corr, cmap="magma", linewidths=.1, ax=ax)
heatmap.set_title("Correlation Between Pokemon Stats", fontsize=30)

# Rotate the x-axis labels to make them readable
ax.tick_params(axis='x', labelrotation=90)

# Show the graph
plt.show()

### Graph 2 - wordcloud

# Get data about names
names = merged_stats["name"]

# Combine all the names into a single string
all_names = " ".join(names)

# Create a WordCloud object with desired parameters
wordcloud = WordCloud(width = 400, height = 400, 
                background_color ='white', 
                min_font_size = 3).generate(all_names)

# Create a figure and axes objects
fig, ax = plt.subplots(figsize=(8, 8), facecolor=None)

# Plot the WordCloud on the axes and set the title
ax.imshow(wordcloud)
ax.axis("off")
ax.set_title("Most Used Pokemon in Gen 7 ou", fontsize=20)

# Show the plot
plt.show()

### Graph 3 - Plotly Scatter/Bar

# There are holes in this graph and idk why

# Select on rank and on usage
rank = merged_stats["Rank"]
real = merged_stats["Real"]

# Makes figure
plot = go.Figure(data=[go.Scatter(
	x=rank,
	y=real,
	mode='markers',)
])

# Add button functionality
plot.update_layout(
	updatemenus=[
		dict(
			type="buttons",
			direction="left",
			buttons=list([
				dict(
					args=["type", "scatter"],
					label="Scatter Plot",
					method="restyle"
				),
				dict(
					args=["type", "bar"],
					label="Bar Chart",
					method="restyle"
				)
			]),
		),
	],
    # add title and axis labels
	title="Usage Required for a High Rank",
	xaxis_title="Rank",
	yaxis_title="Adjusted Usage"
)

# plot.show()
plotly.offline.plot(plot, filename='graph3.html')

### Graph 4 - Rank/BST with Speed Animation

# Sorts by speed
merged_stats = merged_stats.sort_values('speed', ascending=False)

# Preps scatter
plot = px.scatter(
    merged_stats,
    x='Rank',
    y='base_total',
    animation_frame='speed',
     range_y =[200, 1000],
     range_x = [0, 500],
    title='Ranked Pokemon Base Stats by Speed'
)

plotly.offline.plot(plot, filename='graph4.html')

### Graph 5 - Rank/BST with Speed Animation

# Sorts by speed
merged_stats = merged_stats.sort_values('generation', ascending=True)

# Preps scatter
plot = px.scatter(
    merged_stats,
    x='Rank',
    y='attack',
    animation_frame='generation',
    size="Usage%",
     range_y =[0, 200],
     range_x = [0, 500],
    color="base_total",
    title='Ranked Pokemon Attack by Generation'
)

plotly.offline.plot(plot, filename='graph5.html')
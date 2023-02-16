# Jack Goetzmann
# Adv Prog Data Viz
# February 2022

# A graph showing the ability to use plotly and more specifically the ability to
# have a button/dropdown and hover text using the pokemon dataset

import plotly.graph_objects as px
import pandas as pd
import plotly

# Reads in data
df = pd.read_csv("HW04-Refresher\\plotly-assignments\\Pokemon.csv")

# print(df.head(15))

# Takes out parts of dataframe
x_data = df["Name"]
y_data = df["Total"]

# Makes figure
plot = px.Figure(data=[px.Scatter(
	x=x_data,
	y=y_data,
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
	]
)

# plot.show()
plotly.offline.plot(plot, filename='buttons.html')

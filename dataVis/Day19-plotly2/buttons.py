import plotly.graph_objects as px
import numpy as np
import plotly

# creating random data through randomint
# function of numpy.random
np.random.seed(42)

random_x = np.random.randint(1, 101, 100)
random_y = np.random.randint(1, 101, 100)

plot = px.Figure(data=[px.Scatter(
	x=random_x,
	y=random_y,
	mode='markers',)
])

# Add dropdown
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

import plotly.graph_objects as px
import numpy as np
import plotly.graph_objects as go
import plotly


# creating random data through randomint
# function of numpy.random
np.random.seed(42)

random_x = np.random.randint(1, 101, 100)
random_y = np.random.randint(1, 101, 100)

x = ['A', 'B', 'C', 'D']

plot = px.Figure(data=[go.Bar(
	name='Data 1',
	x=x,
	y=[100, 200, 500, 673]
),
	go.Bar(
	name='Data 2',
	x=x,
	y=[56, 123, 982, 213]
)
])


# Add dropdown
plot.update_layout(
	updatemenus=[
		dict(
			active=0,
			buttons=list([
				dict(label="Both",
					method="update",
					args=[{"visible": [True, True]},
						{"title": "Both"}]),
				dict(label="Data 1",
					method="update",
					args=[{"visible": [True, False]},
						{"title": "Data 1",
							}]),
				dict(label="Data 2",
					method="update",
					args=[{"visible": [False, True]},
						{"title": "Data 2",
							}]),
			]),
		)
	])


# plot.show()
plotly.offline.plot(plot, filename='dropdowns2.html')
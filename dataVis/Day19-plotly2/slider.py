import plotly.graph_objects as px
import plotly.express as go
import numpy as np
import plotly

df = go.data.tips()

x = df['total_bill']
y = df['day']

plot = px.Figure(data=[px.Scatter(
	x=x,
	y=y,
	mode='lines',)
])

plot.update_layout(
	xaxis=dict(
		rangeselector=dict(
			buttons=list([
				dict(count=1,
					step="day",
					stepmode="backward"),
			])
		),
		rangeslider=dict(
			visible=True
		),
	)
)

# plot.show()
plotly.offline.plot(plot, filename='slider.html')
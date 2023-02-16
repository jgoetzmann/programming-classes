import plotly.graph_objects as go
import plotly

x = ['Suzuki', 'Honda', 'Tata']
y = [100, 40, 60]
# Use the hovertext kw argument for hover text
fig = go.Figure(data=[go.Bar(x=x, y=y,
            hovertext=['50 % Share', '20 % Share', '30 % Share'])])
fig.update_layout(title_text='Sales Data')
# fig.show()
plotly.offline.plot(fig, filename='third_attempt.html')
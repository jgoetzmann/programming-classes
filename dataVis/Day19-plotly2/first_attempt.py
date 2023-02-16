import plotly.express as px
import plotly

fig = px.line(x=[1,2,3], y=[2,4,6])

# print(fig)
# fig.show()

# html file
plotly.offline.plot(fig, filename='test.html')
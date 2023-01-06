import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
from pywaffle import Waffle

# Make up a raw dataset
df = pd.DataFrame({
    'classyear': ['Freshmen', 'Sophomores', 'Juniors', 'Seniors'],
    'points': [500, 300, 100, 1000] 
})

# Preprocess data to determine size of waffle 
total = sum(df['points'])
proportions = [(float(value) / total) for value in df['points']]

width = 38
height= 10
total= width * height

tiles_per_category = [round(proportion * total) for proportion in proportions]

# Setup a numpy matrix to hold the waffle data
waffle = np.zeros((height, width))
category_index = 0
tile_index = 0
for col in range(width):
    for row in range(height):
        tile_index += 1
        if tile_index > sum(tiles_per_category[0:category_index]):
            category_index += 1
        waffle[row, col] = category_index

# Set up a figure
colormap = plt.cm.coolwarm
plt.matshow(waffle, cmap=colormap)      # turns a matrix into a plot
ax = plt.gca()                          # gets access to the figures. 
ax.set_xticks(np.arange(-0.5, (width), 1), minor=True)
ax.set_yticks(np.arange(-0.5, (height), 1), minor=True)
ax.grid(which='minor', color='w', linestyle='-', linewidth=2)
ax.set_xticks([], minor=False)
ax.set_yticks([], minor=False)

# Setup a nice legend.
values = df['points']
categories = df['classyear']
value_sign = ''
values_cumsum = np.cumsum(values)
total_values = values_cumsum[len(values_cumsum) - 1]
legend_handles = []
for i, category in enumerate(categories):
    if value_sign == '%':
        label_str = category + ' (' + str(values[i]) + value_sign + ')' 
    else:
        label_str = category + ' (' + value_sign + str(values[i]) + ')'
    color_val = colormap(float(values_cumsum[i]) / total_values)
    legend_handles.append(mpatches.Patch(color=color_val, label=label_str))
plt.legend(handles=legend_handles, loc = 'lower center', ncol=len(categories),
          bbox_to_anchor=(0., 0.2, 0.95, 0.1)) #positioning legends


# now use the built in waffle
fig = plt.figure(
    FigureClass=Waffle, 
    rows=10, 
    values=list(df.points/5),
    labels=list(df.classyear),
    figsize=(12, 8),
    legend={'bbox_to_anchor': (0.5, 0.5)}    
)


plt.show()
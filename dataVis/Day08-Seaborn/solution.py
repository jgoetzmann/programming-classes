import pandas as pd
from matplotlib import pyplot as plt
import seaborn as sns

# get the dataset
df = pd.read_csv("dataVis\Day08-Seaborn\Pokemon.csv")
print(df.head())
stats_df = df.drop(['Total', 'Stage', 'Legendary'], axis =1)

sns.set_style("darkgrid")

# # Figure 1 - Default Plot
# sns.lmplot(x='Attack', y='Defense', data = df)
# plt.show()

# # Figure 2 - Simple Scatter
# sns.lmplot(x='Attack', y='Defense', data=df,
#            fit_reg=False, 
#            hue='Stage')  
# plt.show()

# # Figure 3 - Box Plot
# sns.boxplot(data=stats_df)
# plt.show()

# # Figure 4 - Violin Plot
# plt.figure(figsize=(11,6))
# sns.violinplot(x='Type 1', y='Attack', data=df)
# plt.show()

# # Figure 5 - Swarm
# plt.figure(figsize=(11,6))
# sns.swarmplot(x='Type 1', y='Attack', data=df) 
# plt.show()

# # Figure 6 - Overlays
# plt.figure(figsize=(11,6))
# sns.violinplot(x='Type 1', y='Attack', data=df, inner=None) 
# sns.swarmplot(x='Type 1', y='Attack', data=df, color = 'k', alpha=0.7) 
# # plt.ylim(0, 200)
# ax = plt.gca()
# ax.set_ylim(0, 200)
# plt.show()

# Figure 7 - Heatmap
corr = stats_df.corr()
sns.heatmap(corr)
plt.show()

# # Figure 8 - Histograms and KDE
# sns.histplot(df, x='Attack', kde=True)
# sns.histplot(df, x='Defense', kde=True)
# plt.show()

# # Figure 9 a,b,c - Joint Distributions
# sns.jointplot(x="Attack", y="Defense", data=df);
# plt.show()
# sns.jointplot(x="Attack", y="Defense", data=df, kind='kde');
# plt.show()
# sns.jointplot(x="Attack", y="Defense", data=df, kind='hex');
# plt.show()

# # Figure 10 a,b- pairplot + count plot
# sns.countplot(x='Type 1', data=df)
# plt.show()

# sns.pairplot(df, hue='Type 1', size=2.5)
# plt.show()


# # Figure 11 - categorical
# g = sns.catplot(x='Type 1', y='Attack', data=df, 
#                    hue='Stage',  # Color by stage
#                    col='Stage',  # Separate by stage
#                    kind='swarm') # Swarmp
# g.set_xticklabels(rotation=-45)
# plt.show()

# Figure 12 - Facet Grid
g = sns.FacetGrid(df, row="Stage", col="Legendary")
g.map(sns.scatterplot, "Attack", "Defense")
plt.show()

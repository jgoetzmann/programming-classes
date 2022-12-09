import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('dataVis\Day04-Pandas\senate_national_toplines_2022.csv')

chamber_Dparty = df['chamber_Dparty'].to_numpy(dtype='float')
chamber_Rparty = df['chamber_Rparty'].to_numpy(dtype='float')

fig,ax = plt.subplots()
ax.plot(chamber_Dparty, label="dem_chamver")
ax.plot(chamber_Rparty, label="rep_chamber")
ax.set_ylabel("Percentage Chance to Win Control")
ax.set_xlabel("Date")
ax.set_title("Chances for Party to Win Control of Senate")

plt.show()

print(chamber_Dparty)

# print(df)

# print(df.corr(numeric_only=True))

# print(df.head()) # first five rows
# print(df.tail()) # last five rows
# print(df.info()) # prints rows and null values
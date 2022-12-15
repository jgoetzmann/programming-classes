import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('dataVis\Day05-pandas2\senate_state_toplines_2022.csv')

# print(df)

# print(df.corr(numeric_only=True))

# print(df.head()) # first five rows
# print(df.tail()) # last five rows
# print(df.info()) # prints rows and null values

# dropped_df = df.dropna()
# print(dropped_df.info())

df['name_D1'].fillna('', inplace=True)

df['forecastdate'] = pd.to_datetime(df['forecastdate'])

df['timestamp'] = pd.to_datetime(df['timestamp'])

print(df['timestamp'])


for x in df.index :
    if df.loc[x, 'name_R1'] == 'Mehmet Oz' :
        print(df.loc[x, 'name_R1'])
        df.loc[x, 'name_R1'] = 'Dr. Oz'
        print(df.loc[x, 'name_R1'])

df.drop(['name_D2', 'name_D3', 'name_D4'], axis=1, inplace=True)


tmp_df = df.drop(df.index[0], axis=0)
tmp_df = df.drop([0])

tmp_df = tmp_df.drop(tmp_df.columns[63:], axis=1)

print(tmp_df)
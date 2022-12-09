import pandas as pd

# Single series examples
a = [1, 7, 2]

myseries = pd.Series(a, index = ["x", "y", "z"])

print(myseries)

# names

data = {
    "thad moments" : [0, 2, 4],
    "jai moments" : [4, 2, 1]
}

df = pd.DataFrame(data, index = ["day 1", "day 2", "day 3"])
print(df)
print(df.loc["day 1"])
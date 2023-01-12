# Jack Goetzmann
# Adv Prog Data Viz
# January 2023
# Creation Section of Midterm

# Couldnt add color OR how to sort the months

import pandas as pd
import matplotlib.pyplot as plt

# Read in
df = pd.read_csv("Midterm\hotel_bookings.csv")

# Cleans data
df = df.drop_duplicates()
df['arrival_date_month'].fillna('Others',inplace=True)
cleaned_df=df['arrival_date_month'].value_counts().reset_index()
cleaned_df = cleaned_df.rename(columns={'index': 'arrival_date_month','arrival_date_month': 'number of bookings'})[:15]

fig,ax = plt.subplots(figsize=(20,8))

# Added lables and title here
ax.set_title("Total Number of Bookings Across Each Month")
ax.set_xlabel("Months")
ax.set_ylabel("Number_Of_Bookings")

# Stacks a scatter on top of a plot to create viz
ax.plot(cleaned_df['arrival_date_month'],cleaned_df['number of bookings'])
ax.scatter(cleaned_df['arrival_date_month'],cleaned_df['number of bookings'])

plt.show()
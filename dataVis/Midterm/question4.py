# Jack Goetzmann
# Adv Prog Data Viz
# January 2023
# Comments Section of Midterm

# The visualizations produced do not comply with tufte's design principles.
# For starters there is a lot of ambiguity since you dont know how many people
# are represented in each square or what the squares even mean. It is also very
# hard to get a holisitc picture of the visualization without seeing any numbers
# showing the relative percentage of the whole that each part makes up. The 
# waffle chart also isnt aestheitcally pleasing.

import pandas as pd
import matplotlib.pyplot as plt
from pywaffle import Waffle

# Reads in data as df
df = pd.read_csv("Midterm\hotel_bookings.csv")

# Drops duplicate rows/columns
df= df.drop_duplicates()

# Sets a list of rows that need to be cleaned 
null_columns=['agent','children','company']

# Fills null values in rows that needed to be cleaned with 0 
for col in null_columns:
    df[col].fillna(0,inplace=True)

# Creates a new row called 'total_number_of_people' with the value being equal
# to all the people added up together.
df['total_number_of_people'] = df['adults'] + df['babies'] + df['children'] 

# If there arnt any people replace value to true (to signify that there it is
# a cancled trip)
df.drop(df[df['total_number_of_people']==0].index,inplace=True)

# Creates a new row called 'total_stays' with the value being equal to stay on
# weekday nights and weekend nights added up
df['total_stays'] = df['stays_in_weekend_nights'] + df['stays_in_week_nights'] 

# If there arent staying for multiple nights set the value to true (to signify
# that they arnt a repeat costumer)  
df.drop(df[df['total_stays']==0].index,inplace=True)

# Creates waffle for waffle chart
canceled_labels = ['canceled', 'not canceled']

# gets total number of cancled trips
canceled_counts = df['is_canceled'].value_counts()

# Creates a waffle graph
fig = plt.figure(
    FigureClass=Waffle, 
    rows=20, 
    values=list(canceled_counts/100),
    labels=canceled_labels,
    figsize=(12, 8),
    legend={'bbox_to_anchor': (0.5, 0.5)}    
)
plt.show() # shows viz

# Creates lables for waffle chart
repeat_labels = ['repeat customer', 'new customer']
repeat_counts = df['is_repeated_guest'].value_counts()

# Creates a waffle graph
fig = plt.figure(
    FigureClass=Waffle, 
    rows=20, 
    values=list(repeat_counts/100),
    labels=repeat_labels,
    figsize=(12, 8),
    legend={'bbox_to_anchor': (0.5, 0.5)}    
)

plt.show() # shows viz
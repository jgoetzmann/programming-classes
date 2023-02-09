import matplotlib.pyplot as plt
import numpy as np

thad = [
    2,
    4,
    14,
    15,
    18,
    27,
    20,
    10,
    0,
    1,
    1,
    2,
    3,
    5,
    8,
    13,
    21,
    34,
    50,
    1
]

# plot
fig,ax = plt.subplots()
ax.plot(thad, label="Thaddeous Momentos")
# lables
ax.set_ylabel("Number of Momentos")
ax.set_xlabel("Class Day")
ax.set_title("Number of Thaddeus Momentos by Day")
# how to add ticks, colors, and do anything im just lost???
# ticks
# ax.set
# ax.set_yticks(2)
# show
plt.show()
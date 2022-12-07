import matplotlib.pyplot as plt
import numpy as np

dem =  [44.146218,
        44.146218,
        44.146218,
        44.146218,
        44.146218,
        44.146218,
        43.146218,
        43.146218,
        43.146218,
        43.146218,
        43.146218,
        44.146218,
        44.146218,
        44.146218,
        44.146218,
        41.870569,
        44.146218,
        44.146218,
        44.146218,
        44.146218,
        44.146218,
        43.146218,
        43.146218,
        45.428483,
        43.146218,
        43.146218,
        40.663717,
        43.146218,
        43.146218,
        43.146218,
        45.377178,
        44.146218,
        42.098445] 
rep = [41.920013,
        41.920013,
        41.920013,
        41.920013,
        41.920013,
        41.920013,
        41.920013,
        41.920013,
        41.920013,
        41.920013,
        41.920013,
        40.920013,
        40.920013,
        40.920013,
        41.920013,
        43.673985,
        41.920013,
        41.920013,
        41.920013,
        40.920013,
        40.920013,
        41.920013,
        41.920013,
        40.577652,
        41.920013,
        41.920013,
        38.993693,
        41.920013,
        41.920013,
        41.920013,
        43.048764,
        41.920013,
        35.973137]
days = np.linspace(1,32,33)

# line
fig,ax = plt.subplots(2, 1)
ax[0].plot(dem, label="democratic")
ax[0].plot(rep, label='republican')
# plt.show()

# scatter
# fig,ax = plt.subplots()
ax[1].scatter(days, dem, label="democratic")
ax[1].scatter(days, rep, label='republican')
plt.show()

# bar
fig,ax = plt.subplots()
ax.bar(days, dem, label="democratic")
ax.bar(days, rep, label='republican')
plt.show()

# histogram
fig,ax = plt.subplots()
ax.hist(dem, bins = 8, label="democratic")
plt.show()

# pie
fig,ax = plt.subplots()
ax.pie(dem)
plt.show()
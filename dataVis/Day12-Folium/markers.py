import pandas as pd
import folium


m = folium.Map(location=[45.372, -121.6972], 
                zoom_start=12, tiles="Stamen Terrain")

tooltip = "Click me!"
folium.Marker([45.3288, -121.6625], 
                popup="<i>Mt. Hood Meadows</i>", 
                tooltip=tooltip).add_to(m)
folium.Marker([45.3311, -121.7113], 
                popup="<b>Timberline Lodge</b>", 
                tooltip=tooltip).add_to(m)
m.save("hood.html")



m = folium.Map(location=[45.372, -121.6972], 
                zoom_start=12, 
                tiles="Stamen Terrain")

folium.Marker(location=[45.3288, -121.6625],
                popup="Mt. Hood Meadows",
                icon=folium.Icon(icon="cloud"),).add_to(m)
folium.Marker(location=[45.3311, -121.7113],
                popup="Timberline Lodge",
                icon=folium.Icon(color="green")
                ).add_to(m)
folium.Marker(location=[45.3300, -121.6823],
                popup="Some Other Location",
                icon=folium.Icon(color="red", icon="info-sign")
                ).add_to(m)
m.save("hood2.html")

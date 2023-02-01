import folium

my_map = folium.Map(location=[47.6062, -122.3321], 
                zoom_start=13)

my_map.save("basic.html")


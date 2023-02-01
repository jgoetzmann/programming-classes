import folium

my_map = folium.Map(location=[47.6062, -122.3321], 
                zoom_start=13)

folium.TileLayer('openstreetmap').add_to(my_map)

# folium.TileLayer('mapquestopen').add_to(my_map)
# folium.TileLayer('MapQuest Open Aerial').add_to(my_map)
# folium.TileLayer('Mapbox Bright').add_to(my_map)
# folium.TileLayer('Mapbox Control Room').add_to(my_map)

folium.TileLayer('stamenterrain').add_to(my_map)
folium.TileLayer('stamentoner').add_to(my_map)
folium.TileLayer('stamenwatercolor').add_to(my_map)

folium.TileLayer('cartodbpositron').add_to(my_map)
folium.TileLayer('cartodbdark_matter').add_to(my_map)

folium.LayerControl().add_to(my_map)

my_map.save("eps.html")


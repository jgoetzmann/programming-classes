import folium
m = folium.Map(location=[45.5236, -122.6750], 
                tiles="Stamen Toner", zoom_start=13)

folium.Circle(radius=100,
                location=[45.5244, -122.6699],
                popup="The Waterfront",
                color="crimson",
                fill=False).add_to(m)

folium.CircleMarker(radius=50,
                location=[45.5215, -122.6261],
                popup="Laurelhurst Park",
                color="#3186cc",
                fill=True,
                fill_color="#3186cc",).add_to(m)

lat_lng_points = [[45.5244, -122.6699],
                  [45.5215, -122.6261]]
folium.PolyLine(lat_lng_points,
                color="orange",
                tooltip="PolyLine",
                weight=5,  
                opacity=0.8  
                ).add_to(m)

m.save("portland.html")
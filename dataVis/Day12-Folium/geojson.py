import folium, json, requests

url = ("https://raw.githubusercontent.com/python-visualization/folium/master/examples/data")

antarctic_ice_edge = f"{url}/antarctic_ice_edge.json"
antarctic_ice_shelf_topo = f"{url}/antarctic_ice_shelf_topo.json"


m = folium.Map(location=[-59.1759, -11.6016],
                tiles="cartodbpositron",
                zoom_start=2)

folium.GeoJson(antarctic_ice_edge, name="geojson").add_to(m)

folium.TopoJson(json.loads(requests.get(antarctic_ice_shelf_topo).text),
                "objects.antarctic_ice_shelf",
                name="topojson",
                ).add_to(m)

folium.LayerControl().add_to(m)

m.save("ice.html")

# https://www.naturalearthdata.com/
# https://geojson.io/#new&map=2/0/20
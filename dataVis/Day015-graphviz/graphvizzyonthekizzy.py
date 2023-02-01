import graphviz

f = graphviz.Graph('vehd_head_is_cool', format='png')
names = ['root','1W','1L', '2W', '2L', '3W', '3L']
positions = ['start','9/10','1/10','8/9', '1/9', '7/8', '1/8']

for name, position in zip(names, positions):
     f.node(name, position)

#Specify edges
f.edge('start','9/10'); f.edge('start','1/10')
f.edge('9/10','8/9'); f.edge('9/10','1/9')
f.edge('8/9','7/8'); f.edge('8/9','1/8')

print(f.source)
f.render()
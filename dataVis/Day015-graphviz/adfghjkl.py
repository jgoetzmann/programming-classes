import graphviz

f = graphviz.Graph('plain_organogram_1', format='png')
names = ['A','B', 'C', 'D', 'E', 'F', 'G', 'H']
positions = ['CEO','Team A Lead','Team B Lead', 
               'Staff A','Staff B', 'Staff C', 'Staff D', 'Staff E']

# for name, position in zip(names, positions):
#      f.node(name, position)

# #Specify edges
# f.edge('A','B'); f.edge('A','C') #CEO to Team Leads
# f.edge('B','D'); f.edge('B','E') #Team A relationship
# f.edge('C','F'); f.edge('C','G'); f.edge('C','H') #Team B relationship

# print(f.source)
# f.render()




# f = graphviz.Graph('plain_organogram_2', format='png')
 
# for name, position in zip(names, positions):
#     if name == "A":
#         f.node(name, position, shape = "oval")
        
#     elif name in ["B","C"]:
#         f.node(name, position, shape = "box")
#     else:
#         f.node(name, position, shape = "plaintext")

# #Specify edges
# f.edge('A','B'); f.edge('A','C') #CEO to Team Leads
# f.edge('B','D'); f.edge('B','E') #Team A relationship
# f.edge('C','F'); f.edge('C','G'); f.edge('C','H') #Team B relationship

# print(f.source)
# f.render()

# f = graphviz.Graph('plain_organogram_3', format='png')
# colors = ["black", "blue", "red", "blue", "blue", "red", "red", "red"]

# for name, position, color in zip(names, positions, colors):
#     if name == "A":
#         f.node(name, position, shape = "oval", color=color)
        
#     elif name in ["B","C"]:
#         f.node(name, position, shape = "box", color=color)
#     else:
#         f.node(name, position, shape = "plaintext", color=color)

# #Specify edges
# f.edge('A','B'); f.edge('A','C') #CEO to Team Leads
# f.edge('B','D'); f.edge('B','E') #Team A relationship
# f.edge('C','F'); f.edge('C','G'); f.edge('C','H') #Team B relationship

# print(f.source)
# f.render()

f = graphviz.Graph('plain_organogram_4', format='png')
colors = ["black", "blue", "red", "blue", "blue", "red", "red", "red"]

colors = ["black", "skyblue", "mistyrose", "skyblue", "skyblue", "mistyrose", "mistyrose", "mistyrose"]
for name, position, color in zip(names, positions, colors):
    if name== "A":
        f.node(name, position, color = color)
    else:
        f.node(name, position, style = "filled", color = color)
    

#Specify edges
f.edge('A','B'); f.edge('A','C') #CEO to Team Leads
f.edge('B','D'); f.edge('B','E') #Team A relationship
f.edge('C','F'); f.edge('C','G'); f.edge('C','H') #Team B relationship

print(f.source)
f.render()

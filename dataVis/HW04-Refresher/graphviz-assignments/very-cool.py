# Jack Goetzmann
# Adv Prog Data Viz
# February 2022

# A graph showing the ability to use graphviz and more specifically the ability 
# to have make and customize nodes and edges easily

import graphviz

# Data set
f = graphviz.Graph('very-cool-graph', format='png')
names = ['Start','W1', 'L1', 'W2', 'L2', 'W3', 'L3']
positions = ['Begin','9/10 Win','1/10 Loss', 
               '8/9 Win','1/9 Loss', '7/8 Win', '1/8 Loss']

# Creates nodes
for name, position in zip(names, positions):
     f.node(name, position)

#Specify edges
f.edge('Start','W1'); f.edge('Start','L1') 
f.edge('W1','W2'); f.edge('W1','L2') 
f.edge('W2','W3'); f.edge('W2','L3')

# Add table customization
f.node('Start', label='''<<TABLE border="0" cellborder="1" cellspacing="0" cellpadding="4">
			<TR> <TD> <B>Very Cool Game</B><BR/>You either win or lose </TD> </TR>
			<TR> <TD align="left"><BR align="left"/>
			now find the probability you make it to the end
			<BR align="left"/></TD> </TR>
		</TABLE>>''', color="#000000", shape="plain")

# Add last node customization
f.node('L3', label='<<B>So close to the end, what a shame</B>>') 

print(f.source)
f.render()
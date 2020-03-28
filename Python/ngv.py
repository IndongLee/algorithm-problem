parent = [0, 2, 3, 0 ,3, 2]
tree = [[], [], [1, 5], [2, 4], [], []]
childCount = [0, 0, 0, 0, 0, 0]


def post(node):
    for i in tree[node]:
        post(i)
    childCount[parent[node]] += childCount[node] + 1

post(3)
print(childCount)
print(childCount[3] - childCount[2])
print(childCount[2] - childCount[5])
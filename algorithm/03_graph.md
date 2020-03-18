# Graph

[TOC]

## 그래프(Graph)

<img src="images/03_graph/00_graph.png" style="zoom:33%;" />

일련의 `노드(node)` 집합 V와 그 노드를 연결하는 `간선(edge)`의 집합 E로 구성된 자료구조의 일종이다.

- 즉, 연결되어 있는 객체 간의 관계를 표현할 수 있는 자료 구조이다.
- Ex) 지도, 지하철 노선도의 최단 경로, 전기 회로의 소자들, 도로(교차점과 일방 통행길), 선수 과목(찾아 보기) 등
- 그래프는 여러 개의 `고립된 부분 그래프(Isolated Subgraphs)`로 구성될 수 있다.





### 그래프 용어

- **정점(vertex)** : 위치라는 개념. (node 라고도 부름)
- **간선(edge)** : 위치 간의 관계. 즉, 노드를 연결하는 선 (link, branch 라고도 부름)
- **인접 정점(adjacent vertex)** : 간선에 의 해 직접 연결된 정점
- **정점의 차수(degree)** : 무방향 그래프에서 하나의 정점에 인접한 정점의 수
  - 무방향 그래프에 존재하는 정점의 모든 차수의 합 = 그래프의 간선 수의 2배
- **진입 차수(in-degree)** : 방향 그래프에서 외부에서 오는 간선의 수 (내차수 라고도 부름)
- **진출 차수(out-degree)** : 방향 그래픙에서 외부로 향하는 간선의 수 (외차수 라고도 부름)
  - 방향 그래프에 있는 정점의 진입 차수 또는 진출 차수의 합 = 방향 그래프의 간선의 수(내차수 + 외차수)
- **경로 길이(path length)** : 경로를 구성하는 데 사용된 간선의 수
- **단순 경로(simple path)** : 경로 중에서 반복되는 정점이 없는 경우
- **루프(loop)** : 한 간선이 같은 정점에 부속해 있는 경우
- **고립 정점(isolated vertex)** : 임의의 한 정점에 부속해 있는 간선이 없을 때





### 그래프의 특징

- 그래프는 네트워크 모델 이다.
- 2개 이상의 경로가 가능하다.
  - 즉, 노드들 사이에 무방향/방향에서 양방향 경로를 가질 수 있다.
- self-loop 뿐 아니라 loop/circuit 모두 가능하다.
- 루트 노드라는 개념이 없다.
- 부모-자식 관계라는 개념이 없다.
- 순회는 DFS나 BFS로 이루어진다.
- 그래프는 `순환(Cyclic)` 혹은 `비순환(Acyclic)`이다.
- 그래프는 크게 방향 그래프와 무방향 그래프가 있다.
- 간선의 유무는 그래프에 따라 다르다.
- 오일러 경로(Eulerian tour)
  - 그래프에 존재하는 모든 간선(edge)을 한 번만 통과하면서 처음 정점(vertex)으로 되돌아오는 경로를 말한다.
  - 그래프의 모든 정점에 연결된 간선의 개수가 짝수일 때만 오일러 경로가 존재한다.





## 그래프(Graph)의 종류

### 무방향 그래프 VS 방향 그래프

<img src="images\03_graph\03_directed.png" alt="03_directed" style="zoom:33%;" />

- 무방향 그래프(Undirected Graph)

  - 무방향 그래프의 간선은 간선을 통해서 양 방향으로 갈 수 있다.
  - 정점 A와 정점 B를 연결하는 간선은 (A, B)와 같이 정점의 쌍으로 표현한다.
    (A, B)는 (B, A) 동일
  - Ex) 양방향 통행 도로

- 방향 그래프(Directed Graph)

  - 간선에 방향성이 존재하는 그래프
  - A -> B로만 갈 수 있는 간선은 <A, B>로 표시한다.
    <A, B>는 <B, A>는 다름
  
  - Ex) 일방 통행



### 가중치 그래프

<img src="images\03_graph\04_weighted.png" alt="04_weighted" style="zoom: 33%;" />

- 가중치 그래프(Weighted Graph)
  - 간선에 비용이나 가중치가 할당된 그래프
  - `네트워크(Network)` 라고도 한다.
  - Ex) 도시-도시의 연결, 도로의 길이, 회로 소자의 용량, 통신망의 사용료 등



### 연결 그래프 VS 비연결 그래프
- 연결 그래프(Connected Graph)
  - 무방향 그래프에 있는 모든 정점쌍에 대해서 항상 경로가 존재하는 경우
  - Ex) 트리(Tree) : 사이클을 가지지 않는 연결 그래프
- 비연결 그래프(Disconnected Graph)
  - 무방향 그래프에서 특정 정점쌍 사이에 경로가 존재하지 않는 경우



### 사이클 VS 비순환 그래프
- 사이클(Cycle)

  - 단순 경로의 시작 정점과 종료 정점이 동일한 경우

  - 단순 경로(Simple Path) : 경로 중에서 반복되는 정점이 없는 경우

- 비순환 그래프(Acyclic Graph)

  - 사이클이 없는 그래프



### 완전 그래프 vs 다중 그래프

<img src="images\03_graph\02_completeMulit.png" alt="02_completeMulit" style="zoom:50%;" />

- 완전 그래프(Complete Graph)
  - 그래프에 속해 있는 모든 정점이 서로 연결되어 있는 그래프
  - 무방향 완전 그래프
    - 정점 수 : n이면 간선의 수: n * (n-1) / 2
- 다중 그래프(Multi Graph)
  - 두 정점을 잇는 간선이 하나 이상일 경우 해당 간선을 `transitive`하다고 한다.
  - transitive한 간선이 존재하는 그래프



### 희소 그래프 vs 밀집 그래프

<img src="images\03_graph\01_denseSparse.png" alt="01_denseSparse" style="zoom:50%;" />

- 희소 그래프(sparse graph)
  - 정점 수보다 간선 수가 적은 그래프
- 밀집 그래프(dence graph)
  - 정점 수보다 간선 수가 많은 그래프





## 연결 관계

### Connected

- 임의의 두 노드가 `연결되었다(connected)`는 것은 두 노드 사이에 경로가 존재한다는 뜻이다.
  
  - 모든 노드쌍 사이에 경로가 존재하는 무방향그래프는 연결되었다고 말한다.
  
  - 임의의 방향그래프에서 방향을 무시하고 보면 연결되어 있을 경우, 해당 방향 그래프는 연결되었다고 말한다.
  
  - 방향그래프의 임의의 노드쌍 `(a, b)`에 대해 `a`에서 `b`로 가는 경로, `b`에서 `a`로 가는 경로가 모두 존재한다면, 해당 방향그래프는 `강연결(strongly connected)`되었다고 말한다.
  
    
  
    <img src="images/03_graph/05_connected.png" style="zoom:33%;" />
  
  -  위 그래프는 임의의 노드쌍 사이에 모두 경로가 존재하기 때문에 `connected graph`이다. 하지만 v<sub>1</sub>에서 v<sub>3</sub>로 가는 경로는 존재하나, 반대로 v<sub>3</sub>에서 v<sub>1</sub>으로 가는 경로는 존재하지 않는다는 점에서 `strongly conntected graph`는 아니다. 



### Connected component

- 원 그래프 ***G***에서 노드와 엣지가 서로 겹치지 않는(*independent*) 부그래프를 ***G***의 `요소(component)`라고 한다. 
- 이들 요소 가운데 요소 내 모든 노드쌍에 대해 경로가 존재하는 부그래프 ***S***를 ***G***의 `연결요소(connected component)`라고 부른다. 
  - `연결그래프(connected graph)`는 하나의 `연결요소(connected component)`만을 가진다.

<img src="images/03_graph/06_connectedComponent.png" style="zoom:33%;" />

- 원 그래프의 부분그래프들 사이에 겹치는 요소가 없고, 부분그래프의 합집합이 원 그래프를 이룰 때 이들 부분그래프를 `파티션(partition)`이라고  한다. 위 그림에서 15개 노드와 모든 엣지를 ***G***로 본다면 ***G***의 연결요소는 두 개이며, 이 연결요소는 ***G***의 `파티션`이다.

- 연결요소 가운데 노드 수가 가장 많은 연결요소를 `최대연결요소(maximal connected component)`라 칭한다.





## 그래프의 구현

### 인접 행렬 (Adjacency Matrix)

- 그래프의 연결 관계를 **이차원 배열**로 나타내는 방식. 인접 행렬을 adj\[ ][ ]라고 한다면 adj\[i][j]에 대해서 다음과 같이 정의할 수 있다.

  ```python
  adj[i][j] : 노드 i에서 노드 j로 가는 간선이 있으면 1, 아니면 0
  
  # 가중치 그래프라면 간선의 가중치를 저장한다.
  ```

- 무방향 그래프를 인접 행렬로 표현한다면 이 행렬은 대칭 행렬(Symmetric Matrix)이 된다.

- 그래프에 간선이 많이 존재하는 밀집 그래프(Dense Graph) 의 경우 유용하다.

#### 시간복잡도와 공간복잡도

- 시간복잡도
  - **노드 i와 노드 j가 연결되어 있는지 확인하고 싶을 때**, adj\[i][j]가 1인지 0인지만 확인하면 되기 때문에 **O(1)**이라는 시간 복잡도에 확인할 수 있다.
  -  **노드 i와 인접한 모든 노드를 찾고 싶을 때**, 인접 행렬의 i행 전체를 조사해야 하기 때문에 **O(V)**만큼의 시간복잡도가 소요된다.
- 공간복잡도
  - 노드 수 * 노드 수 크기의 행렬이 필요하다. 따라서 공간복잡도는 **O(V<sup>2</sup>)**이다.



### 인접 리스트 (Adjacency List)

-  인접 리스트는 그래프의 연결 관계를 **배열**로 나타내는 방식입니다. 이 때 각 배열에는 노드의 번호가 직접 저장됩니다. 인접 리스트는 adj\[i]를 다음과 같이 정의할 수 있다.

  ```python
  adj[i] : 노드 i에 연결된 노드들을 원소로 갖는 vector
      
  # 가중치 그래프라면 (node, weight)의 형태로 저장할 수 있다. 
  ```

-  무방향 그래프(Undirected Graph)에서 (a, b) 간선은 두 번 저장된다.
  
  - 한 번은 a 정점에 인접한 간선을 저장하고 다른 한 번은 b에 인접한 간선을 저장한다.
  
- 그래프 내에 적은 숫자의 간선만을 가지는 희소 그래프(Sparse Graph) 의 경우에 적절하다.



#### 시간복잡도와 공간복잡도

- 시간복잡도
  - **노드 i와 노드 j가 연결되어 있는지 알고 싶다면** adj\[i]의 벡터 전체를 돌며 j를 성분으로 갖는지 확인해야 한다. 따라서 **O(V)**의 시간복잡도가 소요된다.
  - **노드 i와 인접한 모든 노드를 찾고 싶을 때**,  각 노드마다 연결된 노드만 확인하면 된다.**간선의 개수**만큼만 확인해 볼 수가 있습니다. 따라서, **O(E)**의 시간복잡도를 가진다고 할 수 있다.
- 공간복잡도
  - 전체 노드 수 만큼 벡터가 존재해야 하며, 각 노드를 잇는 포인터는 전체 간선의 수만큼 필요하다. 때문에 공간복잡도는 **O(V+E)**가 된다.





## 그래프의 탐색

### 깊이 우선 탐색 (DFS, Depth-First-Search)

<img src="images/03_graph/07_dfs.png" style="zoom: 67%;" />

- 루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법
- 너비 우선 탐색에 비해 좀 더 간단하나, 검색 속도는 느리다.
- 모든 노드를 방문하고자 하는 경우에 이 방법을 선택한다.

- 시간복잡도
  - 인접 리스트 : **O(V+E)**
  - 인접 행렬 : **(O<sup>2</sup>)**



#### DFS의 구현

```kotlin
val adj_list = Array(V + 1) { arrayListOf() }

/*
인접 행렬의 경우
val adj_matrix = Array(V + 1) { Array(V + 1) { 0 } }과 같은 형태로 구현하면 된다.
*/
val visited = Array(V + 1) { false }

# 1. 재귀적 방법을 이용한 구현
fun dfs(node: Int):
    visited[node] = true
    for (next_node in adj_list[node]) {
        if (!visited[next_node]) dfs(next_node)
    }:

    /*
    for (j in 1..V) {
        if (adj_matrix[node][j] && !visited[j]) dfs(j)
    }
    */        
            
# 2. 스택을 이용한 구현
val stack: Stack<Int> = LinkedList()
stack.add(startnode)
while (stack.isNotEmpty()):
    node = stack.pop()
    if (!visited[node]) {
        visited[node] = true
        stack.addAll(adj[node])
    }
```



### 너비 우선 탐색 (BFS, Breath-First-Search)

<img src="images/03_graph/08_bfs.png" style="zoom:67%;" />

-  루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법
- 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법
- 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택한다.
- BFS 는 재귀적으로 동작하지 않는다. 
- 시간복잡도
  - 인접 리스트 : **O(V+E)**
  - 인접 행렬 : **(O<sup>2</sup>)**



#### BFS의 구현

```kotlin
val adj_list = Array(V + 1) { arrayListOf() }

/*
인접 행렬의 경우
val adj_matrix = Array(V + 1) { Array(V + 1) { 0 } }과 같은 형태로 구현하면 된다.
*/
val visited = Array(V + 1) { false }

val queue: Queue<Int> = linkedList()
queue.add(startnode)
visited[startnode] = True
while queue:
    node = queue.pop(0)
    for next_node in adj[node]:
        if not visited[next_node]:
            visited[next_node] = True
            queue.append(next_node)
```


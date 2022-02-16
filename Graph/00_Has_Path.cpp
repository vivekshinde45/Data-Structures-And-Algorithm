https://classroom.pepcoding.com/resources/online-java-foundation/graphs/has-path-official/ojquestion



#include<bits/stdc++.h>
using namespace std;
class Edge {
public:
  int src;
  int nbr;
  int wt;

  Edge(int src, int nbr, int wt) {
    this->src = src;
    this->nbr = nbr;
    this->wt = wt;
  }
};

bool hasPath(vector<Edge> graph[], int src, int dest, vector<bool>& vis) {
  if (src == dest) {
    return true;
  }
  vis[src] = true;
  bool ans = false;;
  for (int i = 0; i < graph[src].size(); i++) {
    Edge e = graph[src][i];
    if (!vis[e.nbr])
      ans = ans || hasPath(graph, e.nbr, dest, vis);
  }
  vis[src] = false;
  return ans;
}


int main() {
  int vtces;
  cin >> vtces;
  vector<Edge> graph[vtces];

  int edges;
  cin >> edges;
  for (int i = 0; i < edges; i++) {
    int v1 ;
    int v2 ;
    int wt ;
    cin >> v1 >> v2 >> wt;
    graph[v1].push_back( Edge(v1, v2, wt));
    graph[v2].push_back( Edge(v2, v1, wt));
  }

  int src;
  cin >> src;
  int dest;
  cin >> dest;
  // write your code here
  vector<bool> vis(vtces);
  bool ans;
  for (int i = 0; i < vtces; i++) {

    if (!vis[i]) {
      ans = hasPath(graph, i, dest, vis);
      if(ans == 0){
          cout << "false";
          return 0;
      }
    }
  }
  cout << "true";


}

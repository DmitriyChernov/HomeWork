using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuickGraph;
using QuickGraph.Algorithms;

namespace Hamilton
{
    public class HamiltonianDefiner
    {
        UndirectedGraph<int, Edge<int>> graph;
        UndirectedGraph<int, Edge<int>> g;
        private int v;

        public HamiltonianDefiner(UndirectedGraph<int, Edge<int>> graph)
        {
            this.graph = graph;
            this.g = graph;
            this.v = graph.VertexCount;
        }

        public bool isHamiltonianGraph(List<int> path)
        {

            if(v == 1)
            {
                return true;
            }
            if (v == 2)
            {
                return false;
            }
            if (posh())
            {
                return true;
            }

            if (checkDegree())
            {
                foreach (int u in graph.Vertices)
                {
                    path.Add(u);
                    if (hamiltonUtil(path, u, u))
                    {
                        return true;
                    } else {
                        path.Remove(u);
                    }
                }
            }

            return false;
        }

        private bool hamiltonUtil(List<int> path, int startV, int curV)
        {
            if (curV == startV && path.Count == v)
            {
                path.Add(curV);
                return true;
            }
            if (curV != startV && path.Count == v+1)
            {
                return false;
            }
            else
            {
                foreach (Edge<int> e in g.AdjacentEdges(curV))
                {
                    int u = e.GetOtherVertex(curV);
                    bool safety = isSafe(startV);
                    if ((safety && !path.Exists(Element => Element == curV)))
                    {
                        path.Add(u);
                        if (hamiltonUtil(path, startV, u))
                        {
                            return true;
                        }
                        else
                        {
                            path.Remove(u);
                            g.AddVertex(u);
                            foreach (Edge<int> edge in graph.AdjacentEdges(u))
                            {
                                if (g.ContainsVertex(edge.Source) && g.ContainsVertex(edge.Target))
                                {
                                    g.AddEdge(edge);
                                }
                            }
                            return false;
                        }
                    }
                }
                return false;
            }
        }

        private bool isSafe(int v)
        {
            return graphIsConnected() && cycleIsPossible(v);
        }

        private bool cycleIsPossible(int start)
        {
            return g.AdjacentEdges(start).Count() != 0;
        }

        private bool graphIsConnected()
        {
            for (int i = 0; i < v; ++i)
            {
                if (g.IsAdjacentEdgesEmpty(i))
                {
                    return false;
                }
            }
            return true;
        }

        private bool checkDegree()
        {
            for (int i = 0; i < v; ++i)
            {
                if (graph.AdjacentDegree(i) < 2)
                {
                    return false;
                }
            }
            return true;
        }


        private bool posh()
        {
            List<Tuple<int, int>> degree = new List<Tuple<int, int>>();
            for(int i = 0; i < v; ++i)
            {
                Tuple<int, int> pair = new Tuple<int, int>(i, graph.AdjacentDegree(i));
                degree.Add(pair);
            }
            degree.Sort((x, y) => x.Item2.CompareTo(y.Item2));

            int mid = (v - 1) / 2;
            for (int k = 0; k < mid; ++k)
            {
                if (!(degree.TakeWhile(item => item.Item2 < k).Count()<k))
                {
                    return false;
                }
            }
            if (v % 2 == 1 && degree.TakeWhile(item => item.Item2 == mid).Count() > mid)
            {
                return false;
            }
            return true;
        }
    }
}

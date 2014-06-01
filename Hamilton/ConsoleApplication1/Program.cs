using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuickGraph;
using QuickGraph.Algorithms;

namespace Hamilton
{
    class Hamilton
    {
        static void Main(string[] args)
        {
            UndirectedGraph<int, Edge<int>> graph = new UndirectedGraph<int, Edge<int>>(true);

            // Add vertices to the graph
            graph.AddVertex(0);
            graph.AddVertex(1);
            graph.AddVertex(2);
            graph.AddVertex(3);
            graph.AddVertex(4);
            graph.AddVertex(5);
            // Create the edges
            Edge<int> e0_1 = new Edge<int>(0, 1);
            Edge<int> e0_2 = new Edge<int>(0, 2);
            Edge<int> e1_2 = new Edge<int>(1, 2);
            Edge<int> e3_4 = new Edge<int>(3, 4);
            Edge<int> e4_5 = new Edge<int>(4, 5);
            Edge<int> e3_5 = new Edge<int>(3, 5);
            // Add the edges
            graph.AddEdge(e0_1);
            graph.AddEdge(e0_2);
            graph.AddEdge(e1_2);
            graph.AddEdge(e3_4);
            graph.AddEdge(e4_5);
            graph.AddEdge(e3_5);

            List<int> path = new List<int>();

            HamiltonianDefiner definer = new HamiltonianDefiner(graph);
            bool isHamiltonian = definer.isHamiltonianGraph(path);
            Console.WriteLine(isHamiltonian);
            Console.ReadLine();
        }
    }
}

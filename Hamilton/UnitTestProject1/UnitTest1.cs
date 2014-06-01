using System;
using System.Collections.Generic;
using QuickGraph;
using QuickGraph.Algorithms;
using NUnit.Framework;

namespace Hamilton.Tests
{
    [TestFixture]
    public class Tester
    {
        public void test1()
        {
            UndirectedGraph<int, Edge<int>> graph = new UndirectedGraph<int, Edge<int>>(true);

            // Add vertices to the graph
            graph.AddVertex(0);
            graph.AddVertex(1);
            graph.AddVertex(2);
            graph.AddVertex(3);
            // Create the edges
            Edge<int> e0_1 = new Edge<int>(0, 1);
            Edge<int> e0_2 = new Edge<int>(0, 2);
            Edge<int> e1_2 = new Edge<int>(1, 2);
            Edge<int> e1_3 = new Edge<int>(1, 3);
            // Add the edges
            graph.AddEdge(e0_1);
            graph.AddEdge(e0_2);
            graph.AddEdge(e1_2);
            graph.AddEdge(e1_3);

            List<int> path = new List<int>();

            HamiltonianDefiner definer = new HamiltonianDefiner(graph);
            bool isHamiltonian = definer.isHamiltonianGraph(path);
            Assert.AreEqual(isHamiltonian, false);
        }

        [Test]
        public void test2()
        {
            UndirectedGraph<int, Edge<int>> graph = new UndirectedGraph<int, Edge<int>>(true);

            // Add vertices to the graph
            graph.AddVertex(0);
            graph.AddVertex(1);
            graph.AddVertex(2);
            // Create the edges
            Edge<int> e0_1 = new Edge<int>(0, 1);
            Edge<int> e0_2 = new Edge<int>(0, 2);
            Edge<int> e1_2 = new Edge<int>(1, 2);
            // Add the edges
            graph.AddEdge(e0_1);
            graph.AddEdge(e0_2);
            graph.AddEdge(e1_2);

            List<int> path = new List<int>();

            HamiltonianDefiner definer = new HamiltonianDefiner(graph);
            bool isHamiltonian = definer.isHamiltonianGraph(path);
            Assert.AreEqual(isHamiltonian, true);
        }

        [Test]
        public void test3()
        {
            UndirectedGraph<int, Edge<int>> graph = new UndirectedGraph<int, Edge<int>>(true);

            // Add vertices to the graph
            graph.AddVertex(0);
            graph.AddVertex(1);
            graph.AddVertex(2);
            graph.AddVertex(3);
            graph.AddVertex(4);
            // Create the edges
            Edge<int> e0_1 = new Edge<int>(0, 1);
            Edge<int> e0_2 = new Edge<int>(0, 2);
            Edge<int> e1_4 = new Edge<int>(1, 4);
            Edge<int> e3_4 = new Edge<int>(3, 4);
            Edge<int> e0_3 = new Edge<int>(0, 3);
            Edge<int> e1_2 = new Edge<int>(1, 2);
            // Add the edges
            graph.AddEdge(e0_1);
            graph.AddEdge(e0_2);
            graph.AddEdge(e1_2);
            graph.AddEdge(e1_4);
            graph.AddEdge(e3_4);
            graph.AddEdge(e0_3);

            List<int> path = new List<int>();

            HamiltonianDefiner definer = new HamiltonianDefiner(graph);
            bool isHamiltonian = definer.isHamiltonianGraph(path);
            Assert.AreEqual(isHamiltonian, true);
        }

        [Test]
        public void test4()
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
            Assert.AreEqual(isHamiltonian, false);
        }

        [Test]
        public void test5()
        {
            UndirectedGraph<int, Edge<int>> graph = new UndirectedGraph<int, Edge<int>>(true);

            // Add vertices to the graph
            graph.AddVertex(0);
            graph.AddVertex(1);
            graph.AddVertex(2);
            graph.AddVertex(3);
            graph.AddVertex(4);
            // Create the edges
            Edge<int> e0_1 = new Edge<int>(0, 1);
            Edge<int> e0_2 = new Edge<int>(0, 2);
            Edge<int> e1_2 = new Edge<int>(1, 2);
            Edge<int> e0_3 = new Edge<int>(0, 3);
            Edge<int> e0_4 = new Edge<int>(0, 4);
            Edge<int> e3_4 = new Edge<int>(3, 4);
            // Add the edges
            graph.AddEdge(e0_1);
            graph.AddEdge(e0_2);
            graph.AddEdge(e1_2);
            graph.AddEdge(e0_3);
            graph.AddEdge(e0_4);
            graph.AddEdge(e3_4);

            List<int> path = new List<int>();

            HamiltonianDefiner definer = new HamiltonianDefiner(graph);
            bool isHamiltonian = definer.isHamiltonianGraph(path);
            Assert.AreEqual(isHamiltonian, false);
        }

        [Test]
        public void test6()
        {
            UndirectedGraph<int, Edge<int>> graph = new UndirectedGraph<int, Edge<int>>(true);

            // Add vertices to the graph
            graph.AddVertex(0);
            graph.AddVertex(1);
            // Create the edges
            Edge<int> e0_1 = new Edge<int>(0, 1);
            // Add the edges
            graph.AddEdge(e0_1);

            List<int> path = new List<int>();

            HamiltonianDefiner definer = new HamiltonianDefiner(graph);
            bool isHamiltonian = definer.isHamiltonianGraph(path);
            Assert.AreEqual(isHamiltonian, false);
        }
    }
}

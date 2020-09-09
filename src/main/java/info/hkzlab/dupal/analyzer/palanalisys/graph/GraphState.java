package info.hkzlab.dupal.analyzer.palanalisys.graph;

public interface GraphState {
    public int[] getInternalState();

    public boolean isStateFull();
    public GraphLink[] getLinks();
    public int getMaxLinks();
}

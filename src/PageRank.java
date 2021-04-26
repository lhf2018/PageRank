import java.util.*;

/**
 * 理论参考 https://zhuanlan.zhihu.com/p/86004363
 *
 */
public class PageRank {
    private final static double DISTANCE=0.000001;//误差值
    private final static double d=0.85;//阻尼系数
    /*
    name_to_node:名字到节点转换
     */
    private static Map<String,PageNode> name_to_node=new HashMap<>();
    public static List<PageNode> build(){
        List<PageNode> graph=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        int len=Integer.parseInt(in.nextLine());
        System.out.println(len);
        for (int j=0;j<len;j++){
            String line=in.nextLine();
            String[] temp=line.split(" ");
            List<String> edge=new ArrayList<>();
            PageNode pageNode=new PageNode(temp[0]);
            for(int i=1;i<temp.length;i++){
                edge.add(temp[i]);
            }
            pageNode.setEdges(new ArrayList<>(edge));
            name_to_node.put(pageNode.getNodeName(),pageNode);
            graph.add(pageNode);
        }
        return graph;
    }
    public static void Cal(List<PageNode> graph){
        double common=(1-d)/graph.size();
        while (true){
            for(PageNode node:graph){
                double sum=0;
                for(String name:node.getEdges()){
                    PageNode edgeNode=name_to_node.get(name);
                    sum+=(edgeNode.getScore()/edgeNode.getLen());
                }
                double newScore=common+d*sum;
                if(Math.abs(node.getScore()-newScore)<DISTANCE){
                    return;
                }else {
                    node.setScore(newScore);
                }
            }
        }
    }
}

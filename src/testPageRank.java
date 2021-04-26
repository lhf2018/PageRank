import java.util.Collections;
import java.util.List;
/**无向图
 * 5
 * A B C D E
 * B A E
 * C A D
 * D A C
 * E A B
 *
 *
 * A : 0.3193032728467021
 * B : 0.170178554419658
 * C : 0.170178554419658
 * D : 0.17017823716469735
 * E : 0.17017823716469735
 *
 */
public class testPageRank {
    public static void main(String[] args) {
        List<PageNode> graph =PageRank.build();
        PageRank.Cal(graph);
        Collections.sort(graph);
        for(PageNode node:graph){
            System.out.println(node.getNodeName()+" : "+node.getScore());
        }
    }
}

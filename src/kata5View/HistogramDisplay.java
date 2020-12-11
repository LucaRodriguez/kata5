package kata5View;
import kata5model.Histogram;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;



public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram<String> histogram){
        super(title);
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
        
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", 
                                    "Dominios email", 
                                    "nº de emails", 
                                    dataSet, 
                                    PlotOrientation.VERTICAL, 
                                    false, 
                                    false, 
                                    rootPaneCheckingEnabled);
        return chart;
        
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int other = 0;
        for (String key : histogram.keySet()){
            if(histogram.get(key) > 1){
                dataset.addValue(histogram.get(key),"",key);
            }else{
                other++;
            }
            
        }
        dataset.addValue(other, "","others");
        return dataset;
    }
}
    


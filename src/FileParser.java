import model.NetflixDataModel;

import java.util.List;

public interface FileParser {
     List<NetflixDataModel> processInputFile(String inputFilePath);
}

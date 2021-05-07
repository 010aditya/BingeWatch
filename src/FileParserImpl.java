
import model.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static common.Constants.PATTERN;


public class FileParserImpl implements FileParser {

    @Override
    public List<Show> processInputFile(String inputFilePath) {
        List<Show> inputList = new ArrayList<>();
        try {
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (Exception e) {
        }

        return inputList;
    }

    private Function<String, Show> mapToItem = (line) -> {
        String delimiter = PATTERN;

        String[] p = line.split(delimiter);
        Show item = new Show();
        if (p[0] != null) {
            item.setShowId(p[0]);
        }
        if (p[1] != null) {
            item.setType(p[1]);
        }
        if (p[2] != null) {
            item.setTitle(p[2]);
        }
        if (p[3] != null) {
            item.setDirector(p[3]);
        }

        if (p[4] != null) {
            item.setCast(p[4]);
        }
        if (p[5] != null) {
            item.setCountry(p[5]);
        }
        if (p[6] != null) {
            item.setDateAdded(p[6]);
        }
        if (p[7] != null) {
            item.setReleaseYear(p[7]);
        }
        if (p[8] != null) {
            item.setRating(p[8]);
        }
        if (p[9] != null) {
            item.setDuration(p[9]);
        }
        if (p[10] != null) {
            item.setListedIn(p[10]);
        }
        if (p[11] != null) {
            item.setDescription(p[11]);
        }
        return item;

    };

}

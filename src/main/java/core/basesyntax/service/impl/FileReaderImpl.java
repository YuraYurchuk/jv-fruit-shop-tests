package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String file) {
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String value = bufferedReader.readLine(); // skip header (first line)
            if (value == null || value.trim().isEmpty()) {
                throw new RuntimeException("file " + file + " is empty");
            }
            while ((value = bufferedReader.readLine()) != null) {
                data.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + file, e);
        }
        return data;
    }
}

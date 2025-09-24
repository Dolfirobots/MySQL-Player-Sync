package net.dolfirobots.dolfi;

import net.kyori.adventure.text.Component;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.dolfirobots.dolfi.LogsManager.newError;

/**
 * A utility class to manage reading and writing of various data types
 * from and to a plain text file via {@link CustomConfigAPI}.
 * <p>
 * Supports reading data as strings, components, and Java primitive wrapper types.
 * Provides utilities to get a line at a specific index or the full list.
 * </p>
 */
public class TextFilesAPI {
    private static final String service = "TextFilesAPI";

    /**
     * Configuration API wrapper that provides access to the text file.
     */
    private CustomConfigAPI configAPI;

    /**
     * Constructs a new TextFilesAPI instance with the given configuration API.
     *
     * @param configAPI The configuration API instance that provides the file to operate on.
     */
    public TextFilesAPI(CustomConfigAPI configAPI) {
        this.configAPI = configAPI;
    }
    /**
     * Gets the current {@link CustomConfigAPI} instance.
     *
     * @return The current configuration API.
     */
    public CustomConfigAPI getConfigAPI() {
        return configAPI;
    }
    /**
     * Sets the {@link CustomConfigAPI} instance.
     *
     * @param configAPI The configuration API to use.
     */
    public void setConfigAPI(CustomConfigAPI configAPI) {
        this.configAPI = configAPI;
    }

    /**
     * Returns the string content at the specified line index.
     *
     * @param line The index of the line.
     * @return The line content as a string.
     */
    public String getString(int line) {
        return getStrings().get(line);
    }
    /**
     * Reads all lines from the file as strings.
     *
     * @return List of all lines as strings.
     */
    public List<String> getStrings() {
        List<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
            e.printStackTrace();
        }
        return List.of();
    }
    /**
     * Reads all lines from the file and converts them into Adventure {@link Component}s.
     *
     * @return List of lines as {@link Component} objects.
     */
    public List<Component> getComponents() {
        List<Component> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextLine()) {
                list.add(Component.text(scanner.nextLine()));
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
            e.printStackTrace();
        }
        return List.of();
    }

    /**
     * Returns the integer at the specified line index.
     *
     * @param line The index of the line.
     * @return The integer at that index.
     */
    public Integer getInt(int line) {
        return getInts().get(line);
    }
    /**
     * Reads all integers from the file.
     *
     * @return List of integers read from the file.
     */
    public List<Integer> getInts() {
        List<Integer> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
            e.printStackTrace();
        }
        return List.of();
    }

    /**
     * Returns the long value at the specified line index.
     *
     * @param line The index of the line.
     * @return The long value at that index.
     */
    public Long getLong(int line) {
        return getLongs().get(line);
    }
    /**
     * Reads all long values from the file.
     *
     * @return List of long values.
     */
    public List<Long> getLongs() {
        List<Long> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextLong()) {
                list.add(scanner.nextLong());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
            e.printStackTrace();
        }
        return List.of();
    }

    /**
     * Returns the float value at the specified line index.
     *
     * @param line The index of the line.
     * @return The float value at that index.
     */
    public Float getFloat(int line) {
        return getFloats().get(line);
    }
    /**
     * Reads all float values from the file.
     *
     * @return List of float values.
     */
    public List<Float> getFloats() {
        List<Float> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextFloat()) {
                list.add(scanner.nextFloat());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
            e.printStackTrace();
        }
        return List.of();
    }

    /**
     * Returns the short value at the specified line index.
     *
     * @param line The index of the line.
     * @return The short value at that index.
     */
    public Short getShort(int line) {
        return getShorts().get(line);
    }
    /**
     * Reads all short values from the file.
     *
     * @return List of short values.
     */
    public List<Short> getShorts() {
        List<Short> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextShort()) {
                list.add(scanner.nextShort());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
            e.printStackTrace();
        }
        return List.of();
    }

    /**
     * Returns the double value at the specified line index.
     *
     * @param line The index of the line.
     * @return The double value at that index.
     */
    public Double getDouble(int line) {
        return getDoubles().get(line);
    }
    /**
     * Reads all double values from the file.
     *
     * @return List of double values.
     */
    public List<Double> getDoubles() {
        List<Double> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextDouble()) {
                list.add(scanner.nextDouble());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
            e.printStackTrace();
        }
        return List.of();
    }

    /**
     * Returns the byte value at the specified line index.
     *
     * @param line The index of the line.
     * @return The byte value at that index.
     */
    public Byte readBytes(int line) {
        return readAllBytes().get(line);
    }
    /**
     * Reads all byte values from the file.
     *
     * @return List of byte values.
     */
    public List<Byte> readAllBytes() {
        List<Byte> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextByte()) {
                list.add(scanner.nextByte());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
        }
        return List.of();
    }

    /**
     * Returns the boolean value at the specified line index.
     *
     * @param line The index of the line.
     * @return The boolean value at that index.
     */
    public Boolean readBoolean(int line) {
        return readAllBooleans().get(line);
    }
    /**
     * Reads all boolean values from the file.
     *
     * @return List of boolean values.
     */
    public List<Boolean> readAllBooleans() {
        List<Boolean> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextBoolean()) {
                list.add(scanner.nextBoolean());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            newError(service, "Can't load config file!");
        }
        return List.of();
    }

    /// Danger Method
    ///
    /// Rewrites the entire file content with the provided list of strings.
    ///
    /// @param list List of lines to write to the file. Each element represents one line.
    public void setIndex(List<String> list) {
        try {
            FileWriter writer = new FileWriter(configAPI.getFile());
            if (list != null && !list.isEmpty()) {
                for (String s : list) {
                    writer.write(s + "\n");
                }
            }
            writer.close();
        } catch (Exception e) {
            newError(service, "Can't set file index!");
        }

    }

    /**
     * Appends a single line to the end of the file.
     * Adds automatically a linebreak.
     *
     * @param line The line to add.
     */
    public void addLine(String line) {
        try {
            String lastLine = "";
            Scanner scanner = new Scanner(configAPI.getFile());
            while (scanner.hasNextLine()) {
                lastLine = scanner.nextLine();
            }
            scanner.close();

            FileWriter writer = new FileWriter(configAPI.getFile(), true);
            if (!lastLine.isEmpty()) {
                writer.write("\n");
            }
            writer.write(line);
            writer.close();
        } catch (Exception e) {
            newError(service, "Can't add line!");
        }
    }
}

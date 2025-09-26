import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.3
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }
    
    /**
     * Show a list of all the files in the collection with index.
     */
    public void listwithIndex()
    {
        int position = 0;
        for(String filename : files) {
            System.out.println(position + ": " + filename);
            position++;
        }
    }
 
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }

        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    /**
     * Testing MusicOrganizer
     */
    public static void main(String[] args)
    {
         MusicOrganizer music = new MusicOrganizer();
        
        // Add some files to the collection
        music.addFile("Burning man.mp3");
        music.addFile("Livid.mp3");
        music.addFile("Maverick.mp3");
        
        // Test listing all files
        System.out.println("All files:");
        music.listAllFiles();
        
        // Test listing with index
        System.out.println("\nFiles with index:");
        music.listwithIndex();
    }

    /**
     * List files searchString
     */
    public void listMatching(String searchString)
    {
            boolean found = false;  // to check if any matches were found
    // Loop through all filenames
    for(String filename : files) {
        if(filename.contains(searchString)) {
            System.out.println(filename); // print matching file
            found = true;                 // mark that a match was found
        }
    }
    //After loop, verify if no matches were found
    if(!found) {
        System.out.println("No matching files found.");
   
    }

    }
}
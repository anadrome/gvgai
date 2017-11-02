/**
 * Test MCTS scaling curves on VGDL games.
 * mjn, 4/2016
 */

import java.util.Random;

import core.ArcadeMachine;
import core.competition.CompetitionParameters;

public class ScaleTest
{
    /* Usage:
          ./ScaleTest game_name level_num mcts_iterations trials
          levels are a number 0-4
    */
    public static void main(String[] args)
    {
	if (args.length < 4)
	    throw new RuntimeException("Usage: ./ScaleTest game_name level_num mcts_iterations trials");
	
	final String game_name = args[0];
        final int level_num = Integer.parseInt(args[1]);
	final int mcts_iterations = Integer.parseInt(args[2]);
	final int trials = Integer.parseInt(args[3]);

//	CompetitionParameters.ACTION_TIME = action_timelimit;
//	CompetitionParameters.ACTION_TIME_DISQ = action_timelimit + action_timelimit / 4; // keep the same ratio as the 40ms/50ms default

        // use iteration count, with very high timeout so it doesn't interfere
        controllers.sampleMCTSiter.Agent.MCTS_ITERATIONS = mcts_iterations;
        CompetitionParameters.ACTION_TIME = 100000;
        CompetitionParameters.ACTION_TIME_DISQ = 110000;

        // GVGAI competitions have used either 1000 or 2000 timesteps. we use 1000.
	CompetitionParameters.MAX_TIMESTEPS = 1000;

	String game_filename = "examples/gridphysics/" + game_name + ".txt";
	String[] level_filenames = new String[]{ "examples/gridphysics/" + game_name + "_lvl" +level_num + ".txt" }; 

	ArcadeMachine.runGames(game_filename, level_filenames, trials, "controllers.sampleMCTSiter.Agent", null);

    }
}

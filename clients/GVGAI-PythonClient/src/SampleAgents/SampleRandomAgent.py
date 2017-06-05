import random
from SerializableStateObservation import SerializableStateObservation
from Types import Types

class AbstractPlayer:

    def __init__(self):
        pass
    
    def init(sso, elapsedTimer):
     """
     * Public method to be called at the start of every level of a game.
     * Perform any level-entry initialization here.
     * @param sso Phase Observation of the current game.
     * @param elapsedTimer Timer (1s)
     """
         pass

    def act(self, sso, elapsedTimer):
     """
     * Method used to determine the next move to be performed by the agent.
     * This method can be used to identify the current state of the game and all
     * relevant details, then to choose the desired course of action.
     *
     * @param sso Observation of the current state of the game to be used in deciding
     *            the next action to be taken by the agent.
     * @param elapsedTimer Timer (40ms)
     * @return The action to be performed by the agent.
     """
        if sso.gameTick == 100:
            return Types.ACTIONS['ACTION_ESCAPE']

        index = random.randint(0,len(sso.availableActions))
        return sso.availableActions[index]

    def result(self, sso, elapsedTimer):
     """
     * Method used to perform actions in case of a game end.
     * This is the last thing called when a level is played (the game is already in a terminal state).
     * Use this for actions such as teardown or process data.
     *
     * @param sso The current state observation of the game.
     * @param elapsedTimer Timer (up to CompetitionParameters.TOTAL_LEARNING_TIME
     * or CompetitionParameters.EXTRA_LEARNING_TIME if current global time is beyond TOTAL_LEARNING_TIME)
     * @return The next level of the current game to be played.
     * The level is bound in the range of [0,2]. If the input is any different, then the level
     * chosen will be ignored, and the game will play a random one instead.
     """
         return random.randint(0,3)

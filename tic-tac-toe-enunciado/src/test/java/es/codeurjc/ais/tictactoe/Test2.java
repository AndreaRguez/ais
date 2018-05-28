package es.codeurjc.ais.tictactoe;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.hamcrest.MockitoHamcrest;

import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class Test2 {

	@Test
	public void winP1() {
		TicTacToeGame game = new TicTacToeGame();
		Connection c1= mock(Connection.class);
		Connection c2= mock(Connection.class);
		
		
		game.addConnection(c1);
		game.addConnection(c2);
		
		Player p1 = new Player(1,"X","Jugador 1");
		Player p2 = new Player(2,"O","Jugador 2");

		
		game.addPlayer(p1);
		reset(c1);
		reset(c2);
		game.addPlayer(p2);
		
		verify(c1).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(p1,p2)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(p1,p2)));
		
		game.mark(0);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		reset(c1);
		reset(c2);
		
		game.mark(2);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
		reset(c1);
		reset(c2);
		
		game.mark(4);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		reset(c1);
		reset(c2);
		
		game.mark(5);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
		reset(c1);
		reset(c2);
		
		game.mark(8);
			
		ArgumentCaptor<WinnerValue> argument = ArgumentCaptor.forClass(WinnerValue.class);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		
		assertEquals(p1.getId(),argument.getValue().player.getId());
	}
	
	@Test
	public void winP2() {
		TicTacToeGame juego = new TicTacToeGame();
		Connection c1= mock(Connection.class);
		Connection c2= mock(Connection.class);
		
		
		juego.addConnection(c1);
		juego.addConnection(c2);
		
		Player p1 = new Player(1,"X","Jugador 1");
		Player p2 = new Player(2,"O","Jugador 2");

		
		juego.addPlayer(p1);
		reset(c1);
		reset(c2);
		juego.addPlayer(p2);
		
		verify(c1).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(p1,p2)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(p1,p2)));
		
		juego.mark(4);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		reset(c1);
		reset(c2);
		juego.mark(0);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
		reset(c1);
		reset(c2);
		juego.mark(6);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		reset(c1);
		reset(c2);
		juego.mark(2);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
		reset(c1);
		reset(c2);
		juego.mark(7);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		reset(c1);
		reset(c2);
		juego.mark(1);
			
		ArgumentCaptor<WinnerValue> argument = ArgumentCaptor.forClass(WinnerValue.class);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		
		assertEquals(p2.getId(),argument.getValue().player.getId());
	}
	
	@Test
	public void Draw() {
			TicTacToeGame juego = new TicTacToeGame();
			Connection c1= mock(Connection.class);
			Connection c2= mock(Connection.class);
			
			
			juego.addConnection(c1);
			juego.addConnection(c2);
			
			Player p1 = new Player(1,"X","Jugador 1");
			Player p2 = new Player(2,"O","Jugador 2");

			
			juego.addPlayer(p1);
			reset(c1);
			reset(c2);
			juego.addPlayer(p2);
			
			verify(c1).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(p1,p2)));
			verify(c2).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(p1,p2)));
			
			juego.mark(4);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
			reset(c1);
			reset(c2);
			juego.mark(0);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
			reset(c1);
			reset(c2);
			juego.mark(6);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
			reset(c1);
			reset(c2);
			juego.mark(2);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
			reset(c1);
			reset(c2);
			juego.mark(1);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
			reset(c1);
			reset(c2);
			juego.mark(7);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
			reset(c1);
			reset(c2);
			juego.mark(3);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p2));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p2));
			reset(c1);
			reset(c2);
			juego.mark(5);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(p1));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(p1));
			reset(c1);
			reset(c2);
			juego.mark(8);
			
			verify(c1).sendEvent(eq(EventType.GAME_OVER),eq(null));
			verify(c2).sendEvent(eq(EventType.GAME_OVER),eq(null));
			
			
		
	}
	
}


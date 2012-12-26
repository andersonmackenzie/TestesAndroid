package br.com.casa;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Notificacao extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		criarNotificacao(getApplicationContext(), new MsgAlerta(
				"Título: Notificação", "Texto exibido dentro da notificação",
				"Aviso"), Notificacao.class);

	}

	private void criarNotificacao(Context ctx, MsgAlerta msg,
			Class<Notificacao> classe) {

		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		Notification aviso = new Notification(R.drawable.ic_launcher,
				msg.getTitulo(), System.currentTimeMillis());

		aviso.sound = Uri.withAppendedPath(Audio.Media.INTERNAL_CONTENT_URI,
				"6");

		aviso.flags |= Notification.FLAG_INSISTENT;

		aviso.flags |= Notification.FLAG_AUTO_CANCEL;

		PendingIntent pIntent = PendingIntent.getActivity(this, 0,
				new Intent(this.getApplicationContext(), Notificacao.class), 0);

		aviso.setLatestEventInfo(this, msg.getSubtitulo(), msg.getMensagem(), pIntent);

		aviso.vibrate = new long[] { 100, 1000, 1000, 1000 };

		notificationManager.notify(R.string.app_name, aviso);
	}
}

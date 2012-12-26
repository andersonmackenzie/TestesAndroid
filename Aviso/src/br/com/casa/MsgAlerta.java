package br.com.casa;

public class MsgAlerta {

	private CharSequence titulo;
	private CharSequence mensagem;
	private CharSequence subtitulo;

	public MsgAlerta(CharSequence titulo, CharSequence mensagem,
			CharSequence subtitulo) {

		this.titulo = titulo;
		this.mensagem = mensagem;
		this.subtitulo = subtitulo;
	}

	public CharSequence getTitulo() {
		return titulo;
	}

	public void setTitulo(CharSequence titulo) {
		this.titulo = titulo;
	}

	public CharSequence getMensagem() {
		return mensagem;
	}

	public void setMensagem(CharSequence mensagem) {
		this.mensagem = mensagem;
	}

	public CharSequence getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(CharSequence subtitulo) {
		this.subtitulo = subtitulo;
	}

}

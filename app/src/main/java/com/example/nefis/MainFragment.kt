package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title="MX Player 2"

        val categories=ArrayObjectAdapter(ListRowPresenter())

        //categoria 1
        val title="Shitpost"
        val videos=ArrayObjectAdapter(Card())
        videos.addAll(0, listOf(
            Video("Aqua", "Konosuba", R.mipmap.aquaxd, "Aqua siendo Aqua", R.raw.acua),
            Video("Momo 1", "IA momo", R.mipmap.img, "Un momo que pasa en la uni xdxd", R.raw.shitpostuno),
            Video("momo 2", "Creepypasta XDXD", R.mipmap.chopsuey, "Un creepypasta del mejor GTA", R.raw.gtamomo),
            Video("Momo de Homero", "Momo corto", R.mipmap.fogmemez, "Momazo de Homero", R.raw.homerogordo),
            Video("Momo GTA", "Momo", R.mipmap.elzetaql, "Momazo de GTA", R.raw.otrogta),
            ))
        val header=HeaderItem(1, title)
        categories.add(ListRow(header, videos))

        //categoria2
        val title2 = "Gatos"
        val header2=HeaderItem(2, title2)
        val videos2=ArrayObjectAdapter(Card())
        videos2.addAll(0, listOf(
            Video("Tore Tore", "Tore Tore momo", R.mipmap.eatingsand, "Un momo de un gato", R.raw.cat1),
            Video("Canción", "Gato Brazino", R.mipmap.pureevil, "E' Brazino, el juego de eta era", R.raw.brazino),
            Video("Gato mimido", "dormir", R.mipmap.meow, "Momo de gato", R.raw.mimido),
            Video("A veces soy...", "Si", R.mipmap.fornite, "Yo ese", R.raw.sometimes),
            Video("Creep en gatuno", "miau miau miau", R.mipmap.xd, "mia miau miau 😣", R.raw.soyunacrepa),


        ))
        categories.add(ListRow(header2, videos2))

        //categoria3
        val title3 = "Videos Sad :'v"
        val header3=HeaderItem(2, title3)
        val videos3=ArrayObjectAdapter(Card())
        videos3.addAll(0, listOf(
            Video("Sad1", "dibujo", R.mipmap.cat42, "Top T Madagaskar", R.raw.sad1),
            Video("Sad2", "foto", R.mipmap.cat31, "Nooo vegetta", R.raw.sad2),
            Video("Temazo", "XDXD", R.mipmap.cat33, "Papu", R.raw.sad3),
            Video("Gorillazzzz", "A", R.mipmap.yo, "eztzetazeta", R.raw.gorillazzzzz),
            Video("Canción", "Holi", R.mipmap.a, "Cancion de fede pero sin la cancion", R.raw.sixdxd)
        ))
        categories.add(ListRow(header3, videos3))

        val title4 = "Terror"
        val header4 = HeaderItem(3, title4)
        val videos4 = ArrayObjectAdapter(Card())
        videos4.addAll(0, listOf(
            Video("Silent Hill 2", "Videojuegos", R.mipmap.terror1, "Un video de silent hill 2", R.raw.silenciohill1),
            Video("Video de terror", "Miedo", R.mipmap.terror2, "Uy que miedo", R.raw.noches),
            Video("Momo de silent hill 2", "Escena casi final", R.mipmap.terror3, "XDXD", R.raw.silenthillsnowposting),
            Video("Momo del silencio gil 2", "Si", R.mipmap.terror4, "Peak del gaming", R.raw.peak),
            Video("Silent Hill 2 Preview", "Trailer", R.mipmap.terror5, "Es cine", R.raw.noches)


        ))
        categories.add(ListRow(header4, videos4))

        val title5 = "Videos Random"
        val header5 = HeaderItem(4, title5)
        val videos5 = ArrayObjectAdapter(Card())
        videos5.addAll(0, listOf(
            Video("Las tuais", "momo", R.mipmap.uno, "temazo de tuais", R.raw.twice),
            Video("Momo de alecsis", "oal", R.mipmap.dos, "alecsis", R.raw.alexis),
            Video("esbos", "xbox >>> playzzzz", R.mipmap.tres, "momomoom dada", R.raw.momomo),
            Video("20 dolare", "El desinformador", R.mipmap.cuatro, "niges niges", R.raw.niges),
            Video("Tung Tung Tung Sahur vs Ron Damon", "Si", R.mipmap.cinco, "eSO TILIN", R.raw.esotilin),

        ))
        categories.add(ListRow(header5, videos5))


        adapter=categories

        onItemViewClickedListener= OnItemViewClickedListener{ _, video, _, _ ->
            val intent=Intent(requireContext(), PlayActivity::class.java).apply{
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}
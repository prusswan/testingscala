package com.oreilly.testingscala

import org.scalatest.Spec
import org.scalatest.FunSpec
import org.scalatest.matchers.MustMatchers
import org.scalamock.scalatest.MockFactory

class UsingScalaMockSample extends FunSpec with MustMatchers with MockFactory {
  describe("ScalaMocks can create mocks of various structures") {
    it("can create a mock for a trait") {
      val daoMock = mock[DAO]

      //set up actual values to be used.
      val theGratefulDead: Band = new Band("Grateful Dead")
      val wyntonMarsalis: Artist = new Artist("Wynton", "Marsalis")
      val psychedelicFurs: Band = new Band("Psychedelic Furs")
      val ericClapton: Artist = new Artist("Eric", "Clapton")

      val workingmansDead = new Album("Workingman's Dead", 1970, theGratefulDead)
      val midnightToMidnight = new Album("Midnight to Midnight", 1987, psychedelicFurs)
      val wyntonAndClapton = new Album("Wynton Marsalis and Eric Clapton play the Blues", 2011, wyntonMarsalis, ericClapton)

      val jukeBox = new JukeBox(Some(List(workingmansDead, midnightToMidnight, wyntonAndClapton)))

      //create the subject under test
      val jukeboxStorageService = new JukeboxStorageService(daoMock)

      (daoMock.persist _).expects(workingmansDead)
      (daoMock.persist _).expects(midnightToMidnight)
      (daoMock.persist _).expects(wyntonAndClapton)

      (daoMock.persist _).expects(theGratefulDead)
      (daoMock.persist _).expects(psychedelicFurs)
      (daoMock.persist _).expects(wyntonMarsalis)
      (daoMock.persist _).expects(ericClapton)

      jukeboxStorageService.persist(jukeBox)
    }

    // not yet implemented in Scalamock 3, require scala macros
    //    it("can also mock regular object, and along with other traits") {
    //      val daoMock = mock[DAO]
    //
    //      class NoArgsBand extends Band("Grateful Dead")
    //      class NoArgsArtist extends Artist("Wynton", "Marsalis")
    //
    //      //set up actual values to be used.
    //      val theGratefulDead: Band = mock[NoArgsBand]
    //      val wyntonMarsalis: Artist = mock[NoArgsArtist]
    //      val psychedelicFurs: Band = mock[NoArgsBand]
    //      val ericClapton: Artist = mock[NoArgsArtist]
    //
    //      class NoArgsAlbum extends Album("Workingman's Dead", 1970, theGratefulDead)
    //
    //      val workingmansDead = mock[NoArgsAlbum]
    //      val midnightToMidnight = mock[NoArgsAlbum]
    //      val wyntonAndClapton = mock[NoArgsAlbum]
    //
    //      class NoArgsJukeBox extends JukeBox(Some(List(workingmansDead, midnightToMidnight, wyntonAndClapton)))
    //
    //      val jukeBox = mock[NoArgsJukeBox]
    //
    //      //create the subject under test
    //      val jukeboxStorageService = new JukeboxStorageService(daoMock)
    //
    //      inSequence {
    //        jukeBox.expects.albums returning (Some(List(workingmansDead, midnightToMidnight, wyntonAndClapton)))
    //
    //        daoMock.expects.persist(workingmansDead)
    //        workingmansDead.expects.acts returning (List(theGratefulDead))
    //        daoMock.expects.persist(theGratefulDead)
    //
    //        daoMock.expects.persist(midnightToMidnight)
    //        midnightToMidnight.expects.acts returning (List(psychedelicFurs))
    //        daoMock.expects.persist(psychedelicFurs)
    //
    //        daoMock.expects.persist(wyntonAndClapton)
    //        wyntonAndClapton.expects.acts returning (List(ericClapton, wyntonMarsalis))
    //        daoMock.expects.persist(ericClapton)
    //        daoMock.expects.persist(wyntonMarsalis)
    //      }
    //
    //      jukeboxStorageService.persist(jukeBox)
    //    }

    // not yet implemented in Scalamock 3, require scala macros
    //    it("can mock a singleton object") {
    //      val bruceSpringsteenFactory = mockObject(BruceSpringsteenFactory)
    //
    //      val albumMock1 = mock[Album]
    //      val albumMock2 = mock[Album]
    //      val albumMock3 = mock[Album]
    //
    //      albumMock1.expects.year returning (1978)
    //      albumMock2.expects.year returning (1990)
    //      albumMock3.expects.year returning (1999)
    //
    //      bruceSpringsteenFactory.expects.discography returning List(albumMock1, albumMock2, albumMock3)
    //
    //      BruceSpringsteenStatistics.numberOfAlbums must be(3)
    //      BruceSpringsteenStatistics.averageYear must be((1978 + 1990 + 1999) / 3)
    //    }

    // not working with Scalamock 3 yet
    //    it("can mock a companion object") {
    //      val daoMockCompanion = mockObject(DAO)
    //
    //      val daoMockMySql = mock[DAO]
    //      val daoMockDB2 = mock[DAO]
    //
    //      val peterMurphy: Artist = new Artist("Peter", "Murphy")
    //
    //      val cascade = new Album("Cascade", 1995, peterMurphy)
    //
    //      daoMockCompanion.expects.createMySqlDAO returning (daoMockMySql)
    //      daoMockCompanion.expects.createDB2DAO returning (daoMockDB2)
    //
    //      inSequence {
    //        daoMockMySql.expects.persist(cascade)
    //        daoMockDB2.expects.persist(cascade)
    //        daoMockMySql.expects.persist(peterMurphy)
    //        daoMockDB2.expects.persist(peterMurphy)
    //      }
    //
    //      val albumMultipleStorageService = new AlbumMultipleStorageService()
    //      albumMultipleStorageService.persist(cascade);
    //    }
  }
}

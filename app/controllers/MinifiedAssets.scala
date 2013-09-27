package controllers

import play.api.Play
import play.api.Play.current
import play.api.mvc.Action
import play.api.mvc.AnyContent

object MinifiedAssets extends MinifiedAssetsBuilder

/**
 * 
 * In DEV
 * 
 * Can be used to replace default Assets provided by Play.
 * This version try to return a file WITHOUT '.min' in the name of the file to send the source / non minified version
 * If we don't find non-minified file then we send the minified version as expected
 * 
 * In PRODUCTION
 * 
 * /!\ In production do nothing a delegate to normal AssetsBuilder
 * 
 */
class MinifiedAssetsBuilder extends AssetsBuilder {

  override def at(path: String, file: String): Action[AnyContent] = {

    Play.isDev match {
      case true => {
        val devFile = file.replaceAll("""\.min\.""", """\.""");
        val resourceName = Option(path + "/" + devFile).map(name => if (name.startsWith("/")) name else ("/" + name)).get
        Play.resource(resourceName) match {
          case Some(_) => super.at(path, devFile)
          case None => super.at(path, file)
        }
      }
      case _ => super.at(path, file)
    }

  }

}
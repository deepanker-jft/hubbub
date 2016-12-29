/**
 * Created by amit on 29/12/16.
 */
function addChar()
{
    var $p = $('p'),
        $cover = $('.cover'),
        width = $p.width(),
        decrement = width / $p.text().length;

    $cover.css('width', '-=' + decrement);

    if ( parseInt( $cover.css('width') ) < width )
    {
        setTimeout(addChar, 150);
    }
}
addChar();

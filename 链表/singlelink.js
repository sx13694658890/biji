

function single(element){
    let head=null,
    length=0,
    tail=null
    function Node(element){
        this.element=element
        this.next=null
    }
    let current=head,
    index=0;
    this.insert=function(element,position){
       if(position>=-1&&position<=length){
        let node=new Node(element)
         if(position==0){
            if(!head){
                head=node
            }else{
                node.next= current
                head=node
            }
         }else if(position==length-1){
                current=tail
                current.next=node
                tail=node
         }else{
            while(index++<position){
                current=current.next
            }
            node.next=current
            current=node
         }
         length++
         return true
       }
    }
}